package com.julioluis.springbootskillset.prototypes;


import com.julioluis.springbootskillset.entities.Authority;
import com.julioluis.springbootskillset.entities.Rol;
import com.julioluis.springbootskillset.entities.Status;
import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.util.StatusEnum;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    private static Map<ModelType,TrainingProptotype> proptotypeMap=new HashMap<>();

    static {
        // User Template
        User user=new User();
        user.setUsername("julio");
        user.setPassword("admin");
        Rol rol=new Rol();
        rol.setId(1);
        rol.setDescription("ADMIN");
        Authority authority = new Authority();
        authority.setDescription("TRAINING_MAINTANANCE");
        rol.setAuthorities(Arrays.asList(authority));
        user.setRol(rol);
        user.setStatus(new Status(StatusEnum.ACTIVE.getStatus()));








        proptotypeMap.put(ModelType.USER,user);


    }

    public static TrainingProptotype trainingProptotype(ModelType type) throws CloneNotSupportedException {
        return proptotypeMap.get(type).clone();
    }


}
