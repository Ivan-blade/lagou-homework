package com.Ivan.controller;

import com.Ivan.domain.Employee;
import com.Ivan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/24 下午8:26
 * @description
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
        查询所有员工
     */

    @RequestMapping("/findAll")
    public  String findAll(Model model){

        //实现查询所有员工
        List<Employee> list = employeeService.findAll();

        // 把封装好的list存到model中
        model.addAttribute("list",list);

        return "list";

    }

    @RequestMapping("/save")
    public String save(Employee employee){

        employeeService.save(employee);
        // 跳转到findAll方法从新查询一次数据库进行数据的遍历展示
        return "redirect:/employee/findAll";
    }


    /*
        根据id查询账户信息，完成账户回显
     */
    @RequestMapping("/findById")
    public String findById(Integer emp_id,Model model){

        Employee employee =  employeeService.findById(emp_id);

        //存到model中
        model.addAttribute("employee",employee);

        //视图跳转
        return  "update";

    }


    /*
        更新账户
     */
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/findAll";
    }

}
