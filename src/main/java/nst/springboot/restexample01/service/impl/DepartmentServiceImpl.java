package nst.springboot.restexample01.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.domain.Department;
import nst.springboot.restexample01.domain.DepartmentRoleHistory;
import nst.springboot.restexample01.domain.Member;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.repository.DepartmentRepository;
import nst.springboot.restexample01.repository.DepartmentRoleHistoryRepository;
import nst.springboot.restexample01.repository.MemberRepository;
import nst.springboot.restexample01.service.DepartmentService;
import nst.springboot.restexample01.utils.DepartmentRole;
import nst.springboot.restexample01.utils.ExceptionMessagesConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentConverter departmentConverter;

    private final DepartmentRepository departmentRepository;

    private final DepartmentRoleHistoryRepository departmentRoleHistoryRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentConverter departmentConverter, DepartmentRepository departmentRepository,
            DepartmentRoleHistoryRepository departmentRoleHistoryRepository, MemberRepository memberRepository) {
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
        this.departmentRoleHistoryRepository = departmentRoleHistoryRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) throws DepartmentAlreadyExistException {
        departmentDto.setId(null); // transform save or update to save
        Optional<Department> dept = departmentRepository.findByName(departmentDto.getName());
        if (dept.isPresent()) {
            throw new DepartmentAlreadyExistException("Department sa tim imenom postoji!");
        } else {
            Department entity = departmentRepository.save(departmentConverter.toEntity(departmentDto));
            this.saveDepartmentRoleHistory(entity, entity.getManager(), DepartmentRole.MANAGER);
            this.saveDepartmentRoleHistory(entity, entity.getSecretary(), DepartmentRole.SECRETARY);
            return departmentConverter.toDto(entity);
        }
    }

    @Override
    public void delete(Long id) throws NoSuchElementException {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            Department department = dept.get();
            departmentRepository.delete(department);
        } else {
            throw new NoSuchElementException(ExceptionMessagesConstants.DEPARTMENT_NOT_EXIST);
        }
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto) throws NoSuchElementException, DepartmentAlreadyExistException {
        Department oldDepartment = departmentRepository.findById(departmentDto.getId())
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessagesConstants.DEPARTMENT_NOT_EXIST));

        Long oldManager = oldDepartment.getManager();
        Long oldSecretary = oldDepartment.getSecretary();
        Long newManager = departmentDto.getManagerId();
        Long newSecretary = departmentDto.getSecretaryId();

        departmentDto.setId(oldDepartment.getId());

        Optional<Department> departmentByName = departmentRepository.findByName(departmentDto.getName());
        if (departmentByName.isPresent() && !departmentByName.get().getId().equals(departmentDto.getId())) {
            throw new DepartmentAlreadyExistException("Department with that name already exists!");
        }
        if (departmentDto.getManagerId() != null && memberRepository.findById(departmentDto.getManagerId()).isEmpty()) {
            throw new NoSuchElementException("New manager does not exist!");
        }
        if (departmentDto.getSecretaryId() != null
                && memberRepository.findById(departmentDto.getSecretaryId()).isEmpty()) {
            throw new NoSuchElementException("New secretary does not exist!");
        }

        Department newDepartment = departmentRepository.save(departmentConverter.toEntity(departmentDto));
        this.changeDepartmentRoleHistory(oldManager, newManager, newDepartment, DepartmentRole.MANAGER);
        this.changeDepartmentRoleHistory(oldSecretary, newSecretary, newDepartment, DepartmentRole.SECRETARY);
        return departmentConverter.toDto(newDepartment);
    }

    @Override
    public DepartmentDto findById(Long id) throws NoSuchElementException {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            Department department = dept.get();
            return departmentConverter.toDto(department);
        } else {
            throw new NoSuchElementException(ExceptionMessagesConstants.DEPARTMENT_NOT_EXIST);
        }
    }

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(departmentConverter::toDto).toList();
    }

    private void saveDepartmentRoleHistory(Department department, Long memberRoleId, DepartmentRole role) {
        if (memberRoleId == null) {
            return;
        }
        Optional<Member> memberById = memberRepository.findById(memberRoleId);
        if (memberById.isPresent()) {
            departmentRoleHistoryRepository.save(
                    new DepartmentRoleHistory(null, new Date(), null, department, memberById.get(),
                            role.toString()));
        }
    }

    private void changeDepartmentRoleHistory(Long oldUserId, Long newUserId, Department department, DepartmentRole role) throws NoSuchElementException {
        if (oldUserId == null && newUserId != null) {
            this.saveDepartmentRoleHistory(department, newUserId, role);
        } else if (oldUserId != null && newUserId == null) {
            this.endExistingRole(department.getId(), oldUserId, role.toString());
        } else if (oldUserId != null && !oldUserId.equals(newUserId)) {
            this.endExistingRole(department.getId(), oldUserId, role.toString());
            this.saveDepartmentRoleHistory(department, newUserId, role);
        }
    }

    private void endExistingRole(Long departmentId, Long memberId, String role) throws NoSuchElementException {
        DepartmentRoleHistory lastSecretary = departmentRoleHistoryRepository
                .findActiveHistoryByRole(departmentId, role, memberId)
                .orElseThrow(() -> new NoSuchElementException("History for secretary does not exist!"));
        lastSecretary.setEndDate(new Date());
        departmentRoleHistoryRepository.save(lastSecretary);
    }
}
