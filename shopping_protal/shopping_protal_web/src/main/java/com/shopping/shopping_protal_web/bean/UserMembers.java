package com.shopping.shopping_protal_web.bean;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  13:46
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserMembers implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private  String ip;


}
