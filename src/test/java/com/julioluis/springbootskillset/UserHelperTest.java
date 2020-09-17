package com.julioluis.springbootskillset;

import com.julioluis.springbootskillset.entities.Authority;
import com.julioluis.springbootskillset.entities.Rol;
import com.julioluis.springbootskillset.entities.User;
import com.julioluis.springbootskillset.mock.UserDetailsMock;
import com.julioluis.springbootskillset.prototypes.ModelType;
import com.julioluis.springbootskillset.prototypes.PrototypeFactory;
import com.julioluis.springbootskillset.util.BusinessException;
import com.julioluis.springbootskillset.util.UserHelper;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserHelperTest {

    @Mock
    private UserHelper userHelper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAuthorities() throws BusinessException {

        Authority authority = new Authority();
        authority.setDescription("AUTORITY 1");
        List<Authority> authorities= Arrays.asList(authority);
        String [] authoritiesDes={"AUTORITY 1"};

        when(userHelper.authorities(anyList())).thenReturn(authoritiesDes);

        String [] authoritiesStr=userHelper.authorities(authorities);

        assertNotNull(authoritiesStr);
        assertEquals(true,authoritiesStr.length>0);

    }


    @Test
    public void testToUserDetail() throws BusinessException, CloneNotSupportedException {

        User user=(User) PrototypeFactory.trainingProptotype(ModelType.USER);
        if(Objects.isNull(user.getRol().getAuthorities())) {
            Authority authority = new Authority();
            authority.setDescription("TRAINING_MAINTANANCE");
            Rol rol=user.getRol();
            rol.setAuthorities(Arrays.asList(authority));
            user.setRol(rol);
        }

        UserDetailsMock userDetailsMock=new UserDetailsMock();
        when(userHelper.toUserDetail(any())).thenReturn(userDetailsMock);

        UserDetails userDetails=userHelper.toUserDetail(user);

        assertNotNull(userDetails);

    }



}
