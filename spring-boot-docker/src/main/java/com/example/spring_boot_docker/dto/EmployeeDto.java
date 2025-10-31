package com.example.spring_boot_docker.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NotNull(message = "社員IDが割り振られていません")
    private Long employeeId;
    @Size(max = 128)
    @NotBlank(message = "名前を入力してください")
    private String name;
    @NotBlank(message = "年齢を入力してください")
    private Integer ege;
    @Size(min = 0, max = 1)
    @NotBlank(message = "性別を選択してください")
    private Integer sex;
    @Size(min = 1, max = 47)
    @NotBlank(message = "都道府県を選択してください")
    private Integer prefectureId;
    @Size(max = 255)
    @NotBlank(message = "住所を入力してください")
    private String address;
    private List<Integer> hobbyIds;
    @Size(max = 255, message = "自己紹介は255文字以内で入力してください")
    @NotBlank(message = "自己紹介を入力してください")
    private String intro;
    private byte[] image;
}