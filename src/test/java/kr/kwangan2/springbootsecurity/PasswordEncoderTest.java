package kr.kwangan2.springbootsecurity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springbootsecurity.domain.Role;
import kr.kwangan2.springbootsecurity.entity.Member;
import kr.kwangan2.springbootsecurity.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class PasswordEncoderTest {
   
   @Autowired
   private MemberRepository memberRepo;
   
   @Autowired
   private PasswordEncoder encoder;
   
   @Test
   public void testInsert() {
      Member member = new Member();
      
      member.setId("manager2");
      member.setPassword(encoder.encode("manager456"));
      member.setName("๋งค๋์ 2");
      member.setRole(Role.ROLE_MANAGER);
      member.setEnabled("y");
      
      memberRepo.save(member);
   }

}