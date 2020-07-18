package com.example.demo.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank(message = "{require_check}", groups = ValidGroup1.class)
	@Email(message = "{email_check}", groups = ValidGroup2.class)
	private String userId; // ユーザーID

	@NotBlank(message = "{require_check}", groups = ValidGroup1.class)
	@Length(min = 4, max = 100, message = "{length_check}", groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{pattern_check}", groups = ValidGroup3.class)
	private String password; // パスワード

	@NotBlank(message = "{require_check}", groups = ValidGroup1.class)
	private String userName; // ユーザー名

	@NotNull(message = "{require_check}", groups = ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; // 誕生日

	@Min(value = 20, message = "{min_check}", groups = ValidGroup2.class)
	@Max(value = 100, message = "{max_check}", groups = ValidGroup2.class)
	private int age; // 年齢

	// false のみ可能
	@AssertFalse(message = "{false_check}", groups = ValidGroup2.class)
	private boolean marriage; // 結婚ステータス
}
