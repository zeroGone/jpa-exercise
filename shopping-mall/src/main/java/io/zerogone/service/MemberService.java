package io.zerogone.service;

import io.zerogone.domain.Member;
import io.zerogone.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public Long join(Member member) {
        repository.save(member);
        return member.getId();
    }

    public Member findOne(Long memberId) {
        return repository.findOne(memberId);
    }
}
