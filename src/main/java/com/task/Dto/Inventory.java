package com.task.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	
	private Long invId;

	private Long pid;

	private Integer quantity;

	private String isactive;

	private LocalDate createDate;

	private LocalDate updateDate;

}
