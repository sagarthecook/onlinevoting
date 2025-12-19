package com.onlinevoting.service;

import java.util.List;

import com.onlinevoting.dto.MenuDto;

public interface MenuService {
    List<MenuDto> getMenuItemsByRoleId(Long roleId);
<<<<<<< HEAD
    List<MenuDto> getMenuItemsByUserId(String emailId);
    List<MenuDto> getMenuItemsForCurrentUser();
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
}
