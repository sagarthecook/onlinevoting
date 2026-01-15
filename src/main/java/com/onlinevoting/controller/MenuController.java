package com.onlinevoting.controller;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 439abc380dade0c83dadd315c584fb509b33627f
import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.MenuDto;
import com.onlinevoting.service.MenuService;

<<<<<<< HEAD
=======
=======
import com.onlinevoting.dto.MenuDto;
import com.onlinevoting.service.MenuService;
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
>>>>>>> 439abc380dade0c83dadd315c584fb509b33627f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@CrossOrigin(origins = "*", allowedHeaders = "*")
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
public class MenuController {
    
    @Autowired
    private MenuService menuService;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 439abc380dade0c83dadd315c584fb509b33627f
    @GetMapping(path="/v1/menu/user", produces = "application/json")
    public ResponseEntity<ApiResponse<List<MenuDto>>> getMenuForCurrentUser() {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsForCurrentUser();
        return ResponseEntity.ok(new ApiResponse(true, roleMenuItems, null));
<<<<<<< HEAD
=======
=======
    @GetMapping(path="/v1/menu/role/{roleId}", produces = "application/json")
    public ResponseEntity<List<MenuDto>> getMenuByRole(@PathVariable Long roleId) {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsByRoleId(roleId);
        return ResponseEntity.ok(roleMenuItems);
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
>>>>>>> 439abc380dade0c83dadd315c584fb509b33627f
    }
}
