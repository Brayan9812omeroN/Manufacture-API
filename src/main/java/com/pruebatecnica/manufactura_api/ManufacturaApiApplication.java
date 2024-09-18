package com.pruebatecnica.manufactura_api;

import java.util.Set;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pruebatecnica.manufactura_api.model.Elaboration;
import com.pruebatecnica.manufactura_api.model.PermissionEntity;
import com.pruebatecnica.manufactura_api.model.RoleEntity;
import com.pruebatecnica.manufactura_api.model.RoleEnum;
import com.pruebatecnica.manufactura_api.model.Status;
import com.pruebatecnica.manufactura_api.model.UserEntity;
import com.pruebatecnica.manufactura_api.repository.IElaborationRepository;
import com.pruebatecnica.manufactura_api.repository.IStatusRepository;
import com.pruebatecnica.manufactura_api.repository.IUserRepository;

@SpringBootApplication
public class ManufacturaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturaApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initUser(IUserRepository iUserRepository) {
		return args -> {
			if (iUserRepository.count() == 0) {
				PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
				PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
				PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
				PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

				RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
				RoleEntity roleUser = RoleEntity.builder()
                        
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(readPermission, updatePermission))
					.build();
				RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of())
					.build();

				UserEntity userAdmin = UserEntity.builder()
					.username("Admin")
					.password("$2a$10$Pxu5MSGajuYYPOUe4gyy0.72jRGntDZi3ywxe4lhfklgSc3fmWnKW") // Password: 1234
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
				UserEntity userUser = UserEntity.builder()
					.username("User")
					.password("$2a$10$Pxu5MSGajuYYPOUe4gyy0.72jRGntDZi3ywxe4lhfklgSc3fmWnKW") // Password: 1234
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
				UserEntity userInvited = UserEntity.builder()
					.username("Invited")
					.password("$2a$10$Pxu5MSGajuYYPOUe4gyy0.72jRGntDZi3ywxe4lhfklgSc3fmWnKW") // Password: 1234
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

				iUserRepository.saveAll(List.of(userAdmin, userUser, userInvited));
			}
		};
	}

	@Bean
	CommandLineRunner initStatus(IStatusRepository iStatusRepository) {
		return args -> {
			if (iStatusRepository.count() == 0) {
				Status disponible = Status.builder()
					.name("Disponible")
					.build();
				Status defectuoso = Status.builder()
					.name("Defectuoso")
					.build();

				iStatusRepository.saveAll(List.of(disponible, defectuoso));
			}
		};
	}

	@Bean
	CommandLineRunner initElaboration(IElaborationRepository iElaborationRepository) {
		return args -> {
			if (iElaborationRepository.count() == 0) {
				Elaboration elaboradoaMano = Elaboration.builder()
					.name("Elaborado a Mano")
					.build();
				Elaboration elaboradoaManoyMaquina = Elaboration.builder()
					.name("Elaborado a Mano y Maquina")
					.build();

				iElaborationRepository.saveAll(List.of(elaboradoaMano, elaboradoaManoyMaquina));
			}
		};
	}
}