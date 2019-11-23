package br.com.quintoandar.sakuraerrorcaptor.mapper;

import java.util.Base64;

import br.com.quintoandar.sakuraerrorcaptor.dto.TrackedSystemDTO;
import br.com.quintoandar.sakuraerrorcaptor.model.TrackedSystem;

public class TrackedSystemMapper {
	public TrackedSystem map(TrackedSystemDTO systemDTO){
		TrackedSystem trackedSystem =  new TrackedSystem();
		trackedSystem.setName(systemDTO.getName());
		trackedSystem.setLocation(systemDTO.getLocation());
		trackedSystem.setTenant(systemDTO.getTenant());
		trackedSystem.setToken(Base64.getEncoder().encodeToString(new String (systemDTO.getName()+":"+systemDTO.getLocation()).getBytes()));

        return trackedSystem;
    };
}
