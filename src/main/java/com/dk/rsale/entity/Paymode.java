package com.dk.rsale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name="Paymode")
public class Paymode {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int pymid;
private String pydis;
}
