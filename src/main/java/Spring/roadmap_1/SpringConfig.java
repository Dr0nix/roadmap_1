package Spring.roadmap_1;

import Spring.roadmap_1.repository.MemberRepository;
import Spring.roadmap_1.repository.MemoryMemberRepository;
import Spring.roadmap_1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
