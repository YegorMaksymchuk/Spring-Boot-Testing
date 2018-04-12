package com.company.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Film {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String producer;
}