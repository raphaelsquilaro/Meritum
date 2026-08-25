package sp.senai.org.meritum.Core.Role.Service;

import org.springframework.stereotype.Service;
import sp.senai.org.meritum.Core.Role.Domain.Entity.Role;
import sp.senai.org.meritum.Core.Role.Dto.request.RoleRequest;
import sp.senai.org.meritum.Core.Role.Dto.response.RoleResponse;
import sp.senai.org.meritum.Core.Role.Repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<RoleResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RoleResponse findById(Long id) {
        Role role = repository.findById(id)
                .orElseThrow();
        return toResponse(role);
    }

    public RoleResponse create(RoleRequest request) {
        Role role = new Role();

        role.setName(request.name());

        Role savedRole = repository.save(role);

        return toResponse(savedRole);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private RoleResponse toResponse(Role role) {
        return new RoleResponse(
                role.getId(),
                role.getName()
        );
    }
}
