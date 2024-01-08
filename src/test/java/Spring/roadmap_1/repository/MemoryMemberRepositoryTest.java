package Spring.roadmap_1.repository;

import Spring.roadmap_1.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("minju");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // JUnit jupiter 사용
        // Assertions.assertEquals(member, result);

        // assertj 사용
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("minju");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jeon");
        repository.save(member2);

        Member result = repository.findByName("minju").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("minju");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jeon");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
