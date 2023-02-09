package br.com.bello.cinelist.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @Size(min = 15, message = "O email precisa ter mais que 15 caracteres.")
    private String email;
    @Column(name="username", nullable = false, unique = true)
    @Size(min = 4, max = 18, message = "O usuário precisa ter no mínimo 4 caracteres." )
    private String username;
    @Column(name="password", nullable = false)
    @Size(min = 8, max = 150, message = "A senha precisa ter no minímo 8 caracteres.")
    private String password;

    private String pfpUrl;
    
    @ManyToMany
    @JoinTable(name = "tb_user_favoritemovies", joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> favoriteMovies = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "tb_user_towatch", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> toWatch = new HashSet<>();
    
    @ManyToMany
    @JoinTable(name = "tb_user_watchedmovies" , joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> watched = new HashSet<>();

    public User() {
    }

    public User(Long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPfpUrl() {
        return pfpUrl;
    }

    public void setPfpUrl(String pfpUrl) {
        this.pfpUrl = pfpUrl;
    }

    public Set<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }


    public Set<Movie> getToWatch() {
        return toWatch;
    }
    
    
    public Set<Movie> getWatched() {
		return watched;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
