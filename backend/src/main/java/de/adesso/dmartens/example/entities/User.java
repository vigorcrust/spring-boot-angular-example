package de.adesso.dmartens.example.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="User")
@Scope("session")
@NoArgsConstructor
@ToString
@Getter
@Setter
public  class User implements UserDetails{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;

	@Column(unique = true)
	private String username ;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;

    private String role;

    private String fullName;

    public User(String username,String password,String fullName){
    	this.username=username;
    	this.password= password;
    	this.fullName=fullName;
    }

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
}