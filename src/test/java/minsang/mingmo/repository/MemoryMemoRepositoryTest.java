package minsang.mingmo.repository;

import minsang.mingmo.domain.Memo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemoRepositoryTest {
    MemoryMemoRepository repository = new MemoryMemoRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();;
    }

    @Test
    public void save(){
        //given
        Memo memo = new Memo();
        memo.setContent("Test 1");

        //when
        repository.save(memo);

        //then
        Memo result = repository.findById(memo.getId()).get();
        assertThat(result).isEqualTo(memo);
    }

    @Test
    public void findAll(){
        //given
        Memo memo1 = new Memo();
        memo1.setContent("spring1");
        repository.save(memo1);

        Memo memo2 = new Memo();
        memo2.setContent("spring2");
        repository.save(memo2);

        //when
        List<Memo> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
