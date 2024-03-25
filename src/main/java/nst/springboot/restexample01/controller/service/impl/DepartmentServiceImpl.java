package nst.springboot.restexample01.controller.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.DepartmentRoleHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.DepartmentRoleHistoryRepository;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.utils.DepartmentRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentConverter departmentConverter;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentRoleHistoryRepository departmentRoleHistoryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) throws Exception {
        departmentDto.setId(null); // transform save or update to save
        Optional<Department> dept = departmentRepository.findByName(departmentDto.getName());
        if (dept.isPresent()) {
            throw new DepartmentAlreadyExistException("Department sa tim imenom postoji!");
        } else {
            Department entity = departmentRepository.save(departmentConverter.toEntity(departmentDto));
            this.saveDepartmentManagerHistory(entity);
            this.saveDepartmentSecretaryHistory(entity);
            return departmentConverter.toDto(entity);
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            Department department = dept.get();
            departmentRepository.delete(department);
        } else {
            throw new Exception("Department does not exist!");
        }
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto) throws Exception {
        Department oldDepartment = departmentRepository.findById(departmentDto.getId())
                .orElseThrow(() -> new Exception("Department does not exist!"));
        Long oldManager = oldDepartment.getManager();
        Long oldSecretary = oldDepartment.getSecretary();
        departmentDto.setId(oldDepartment.getId());

        Optional<Department> departmentByName = departmentRepository.findByName(departmentDto.getName());
        if (departmentByName.isPresent() && !departmentByName.get().getId().equals(departmentDto.getId())) {
            throw new DepartmentAlreadyExistException("Department with that name already exists!");
        }

        Department newDepartment = departmentRepository.save(departmentConverter.toEntity(departmentDto));
        Long newManager = newDepartment.getManager();
        Long newSecretary = newDepartment.getSecretary();

        System.out.println("oldManager = " + oldManager);
        System.out.println("newManager = " + newManager);
        System.out.println("oldSecretary = " + oldSecretary);
        System.out.println("newSecretary = " + newSecretary);
        this.changeDepartmentRoleHistory(oldManager, newManager, oldSecretary, newSecretary, newDepartment);
        return departmentConverter.toDto(newDepartment);
    }

    @Override
    public DepartmentDto findById(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            Department department = dept.get();
            return departmentConverter.toDto(department);
        } else {
            throw new Exception("Department does not exist!");
        }
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    private void saveDepartmentSecretaryHistory(Department department) throws Exception {
        Member secretary = memberRepository.findById(department.getSecretary())
                .orElseThrow(() -> new Exception("Secretary does not exist!"));

        departmentRoleHistoryRepository.save(
                new DepartmentRoleHistory(null, new Date(), null, department, secretary,
                        DepartmentRole.SECRETARY.toString()));
    }

    private void saveDepartmentManagerHistory(Department department) throws Exception {
        Member manager = memberRepository.findById(department.getManager())
                .orElseThrow(() -> new Exception("Manager does not exist!"));

        departmentRoleHistoryRepository.save(
                new DepartmentRoleHistory(null, new Date(), null, department, manager,
                        DepartmentRole.MANAGER.toString()));
    }

    private void changeDepartmentRoleHistory(Long oldManager, Long newManager, Long oldSecretart, Long newSecretary,
            Department newDep) throws Exception {

        if (!oldManager.equals(newManager)) {
            DepartmentRoleHistory lastManager = departmentRoleHistoryRepository.findByMemberId(oldManager)
                    .orElseThrow(() -> new Exception("History for manager does not exist!"));
            lastManager.setEndDate(new Date());
            departmentRoleHistoryRepository.save(lastManager);
            this.saveDepartmentManagerHistory(newDep);
        }

        if (!oldSecretart.equals(newSecretary)) {
            DepartmentRoleHistory lastSecretary = departmentRoleHistoryRepository.findByMemberId(oldSecretart)
                    .orElseThrow(() -> new Exception("History for secretary does not exist!"));
            lastSecretary.setEndDate(new Date());
            departmentRoleHistoryRepository.save(lastSecretary);
            this.saveDepartmentSecretaryHistory(newDep);
        }
    }
}
