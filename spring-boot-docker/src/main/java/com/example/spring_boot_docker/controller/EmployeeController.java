package com.example.spring_boot_docker.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_boot_docker.dto.EmployeeDto;
import com.example.spring_boot_docker.service.EmployeeService;
import com.example.spring_boot_docker.service.HobbyService;
import com.example.spring_boot_docker.service.PrefectureService;

@Controller
@RequestMapping("/")
@SessionAttributes("employeeDto")
public class EmployeeController {

    @Autowired
    private PrefectureService prefectureService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private HobbyService hobbyService;

    @ModelAttribute("employeeDto")
    public EmployeeDto setupEmployeeDto() {
        return new EmployeeDto();
    }

    @GetMapping("/input")
    public String getMethodName(@ModelAttribute EmployeeDto employeeDto, Model model) {
        Map<String, Integer> prefectures = prefectureService.findAllPrefecture();
        model.addAttribute("prefectures", prefectures);
        Map<Integer, String> hobby = hobbyService.findAllHobbies();
        model.addAttribute("hobby", hobby);
        return "employeeInput.html";
    }

    @GetMapping("/confirm")
    public String confirmView() {
        return "employeeConfirm";
    }

    @PostMapping(value = "/confirm", consumes = { "multipart/form-data" })
    public String inputEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, Model model,
            @RequestParam(value = "imageFile") MultipartFile imageFile, BindingResult bindingResult)
            throws IOException {

        byte[] imageData = imageFile.getBytes();
        employeeDto.setImage(imageData);
        if (bindingResult.hasErrors()) {
            model.addAttribute("prefectures", prefectureService.findAllPrefecture());
            model.addAttribute("hobby", hobbyService.findAllHobbies());
            return "employeeInput";
        }
        return "redirect:/employeeConfirm";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute EmployeeDto employeeDto,Model model, SessionStatus sessionStatus) {
        model.addAttribute("employee", employeeDto);
        employeeService.saveEmployee(employeeDto);
        sessionStatus.setComplete();
        return "redirect:/employeeList";
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<EmployeeDto> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employeeList", employeeList);
        return "employeeList";

    }

}
