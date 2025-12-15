package com.onlinevoting.controller;

import com.onlinevoting.dto.MenuDto;
import com.onlinevoting.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {
    
    @Autowired
    private MenuService menuService;

    @GetMapping(path="/v1/menu/role/{roleId}", produces = "application/json")
    public ResponseEntity<List<MenuDto>> getMenuByRole(@PathVariable Long roleId) {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsByRoleId(roleId);
        return ResponseEntity.ok(roleMenuItems);
    }

    @GetMapping(path="/v1/menu/user/{emailId}", produces = "application/json")
    public ResponseEntity<List<MenuDto>> getMenuByEmailId(@PathVariable String emailId) {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsByUserId(emailId);
        return ResponseEntity.ok(roleMenuItems);
    }
    
    @GetMapping(path="/v1/menu/user", produces = "application/json")
    public ResponseEntity<List<MenuDto>> getMenuForCurrentUser() {
        List<MenuDto> roleMenuItems = menuService.getMenuItemsForCurrentUser();
        return ResponseEntity.ok(roleMenuItems);
    }
}
