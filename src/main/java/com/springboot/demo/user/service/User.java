package com.springboot.demo.user.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
	@NotNull
	private Integer id;
	@NotNull
	private String name;
	private Integer age;
	private String sex;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Min(value = 10)
	private Long phone;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + (int) (phone ^ (phone >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [hashCode()=" + hashCode() + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getSex()=" + getSex() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone()
				+ "]";
	}
	

}
