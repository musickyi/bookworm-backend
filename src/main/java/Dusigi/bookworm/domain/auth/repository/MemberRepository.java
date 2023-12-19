package Dusigi.bookworm.domain.auth.repository;

import Dusigi.bookworm.domain.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findMemberByLoginId(String loginId);

    Optional<Member> findByNickName(String nickname);

    boolean existsByLoginId(String id);
    boolean existsByNickName(String nickname);

}
