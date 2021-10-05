package minsang.mingmo.service;

import minsang.mingmo.domain.Memo;
import minsang.mingmo.repository.MemoRepository;
import minsang.mingmo.repository.MemoryMemoRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemoService {
    //기존에는 직접 생성
    //private final MemoRepository memoRepository = new MemoryMemoRepository();

    //서비스 코드 DI 가능하게
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }
    public Long join(Memo memo){
        //validateDuplicateMemo(memo);
        memoRepository.save(memo);
        return memo.getId();
    }
/*
    private void validateDuplicateMemo(Memo memo){
        memoRepository.findByName(memo.getContent())
                .isPresent(m->{
                    throw new IllegalStateException("~~");
                })
    }
 */
    public List<Memo> findMemos(){
        return memoRepository.findAll();
    }

    public Optional<Memo> findOne(Long memoId){
        return memoRepository.findById(memoId);
    }
}
