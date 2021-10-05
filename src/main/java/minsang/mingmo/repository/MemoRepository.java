package minsang.mingmo.repository;

import minsang.mingmo.domain.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    List<Memo> findAll();
}
