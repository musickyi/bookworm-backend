package Dusigi.bookworm.domain.auth.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id", nullable = false)
    private String id;

    @Column(name = "member_nickname", nullable = false)
    private String nickname;

    @Column(name = "member_password",nullable = false)
    private String password;

}
