package com.bingda.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bingda.blog.dto.MenuDTO;
import com.bingda.blog.dto.LabelOptionDTO;
import com.bingda.blog.dto.UserMenuDTO;
import com.bingda.blog.entity.Menu;
import com.bingda.blog.vo.ConditionVO;
import com.bingda.blog.vo.MenuVO;

import java.util.List;

/**
 * 菜单服务
 *
 * @author yezhiqiu
 * @date 2021/07/29
 */
public interface MenuService extends IService<Menu> {

    /**
     * 查看菜单列表
     *
     * @param conditionVO 条件
     * @return 菜单列表
     */
    List<MenuDTO> listMenus(ConditionVO conditionVO);

    /**
     * 新增或修改菜单
     *
     * @param menuVO 菜单信息
     */
    void saveOrUpdateMenu(MenuVO menuVO);

    /**
     * 删除菜单
     *
     * @param menuId 菜单id
     */
    void deleteMenu(Integer menuId);

    /**
     * 查看角色菜单选项
     *
     * @return 角色菜单选项
     */
    List<LabelOptionDTO> listMenuOptions();

    /**
     * 查看用户菜单
     *
     * @return 菜单列表
     */
    List<UserMenuDTO> listUserMenus();

}
