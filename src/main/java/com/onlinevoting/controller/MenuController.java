package com.onlinevoting.controller;

<<<<<<< HEAD
import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.MenuDto;
import com.onlinevoting.service.MenuService;

=======
import com.onlinevoting.dto.MenuDto;
import com.onlinevoting.service.MenuService;
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
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
    @GetMapping(path="/v1/menu/user", produces = "application/json")
    public ResponseEntity<ApiResponse<List<MenuDto>>> getMenuForCurrentUser() {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsForCurrentUser();
        return ResponseEntity.ok(new ApiResponse(true, roleMenuItems, null));
=======
    @GetMapping(path="/v1/menu/role/{roleId}", produces = "application/json")
    public ResponseEntity<List<MenuDto>> getMenuByRole(@PathVariable Long roleId) {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsByRoleId(roleId);
        return ResponseEntity.ok(roleMenuItems);
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
    }
}
