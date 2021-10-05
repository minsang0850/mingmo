package minsang.mingmo.repository;

import minsang.mingmo.domain.Memo;

import java.util.*;

public class MemoryMemoRepository implements MemoRepository{

    private static Map<Long,Memo> store = new HashMap<>();
    private static long sequence = 0l;

    @Override
    public Memo save(Memo memo) {
        memo.setId(++sequence);
        store.put(memo.getId(),memo);
        return memo;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Memo> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
