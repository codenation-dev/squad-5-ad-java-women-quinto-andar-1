package br.com.quintoandar.sakuraerrorcaptor.mapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.quintoandar.sakuraerrorcaptor.dto.SignInDTO;
import br.com.quintoandar.sakuraerrorcaptor.dto.UserDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.SystemUser;

public class SignInMapper {
	
	public SignInDTO map(SystemUser systemUser){
		SignInDTO signInDTO =  new SignInDTO(
				systemUser.getId(),
				systemUser.getName(),
				systemUser.getEmail(),
				systemUser.getPassword(),
				systemUser.getToken(),
				systemUser.getTenant()
        );

        return signInDTO;
    };
    
    public UserDTO mapUserDto(SystemUser systemUser){
    	UserDTO signInDTO =  new UserDTO(
				systemUser.getId(),
				systemUser.getToken(),
				systemUser.getName()
        );

        return signInDTO;
    };
    
    public List<UserDTO> mapUserDto(List<SystemUser> systemUsers){
    	List<UserDTO> userDTO = new ArrayList<>();

        for(SystemUser user : systemUsers){
        	userDTO.add(mapUserDto(user));
        }
        return userDTO;
    }
        
    
    public List<SignInDTO> map(List<SystemUser> systemUsers){
    	List<SignInDTO> signInDTOs = new ArrayList<>();

        for(SystemUser user : systemUsers){
        	signInDTOs.add(map(user));
        }

        return signInDTOs;
    };
    
    public SystemUser toUser(SignInDTO signInDTO){
    	SystemUser systemUser =  new SystemUser(
    			signInDTO.getId(),
    			signInDTO.getName(),
    			signInDTO.getEmail(),
    			signInDTO.getPassword(),
    			signInDTO.getTenant(),
    			signInDTO.getToken(),
    			false,
    			Date.valueOf(LocalDate.now()),
    			true,
    			null    			
        );

        return systemUser;
    };
    
    public List<UserDTO> mapListUserDto(List<SystemUser> systemUsers){
    	List<UserDTO> userDtos = new ArrayList<>();

        for(SystemUser user : systemUsers){
        	userDtos.add(mapUserDto(user));
        }

        return userDtos;
    };
}
