package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)//이점 찾아보기
@RequiredArgsConstructor
public class MemberService {

    /**
     빈등록
     1. 필드주입 : 테스트 하기 어려움
     2. setter : 누가 set을 바꿀수 있음(혹시 모르기 떄문)
     3. 생성자 주입 : 테스트코드 용이
     */
    private final MemberRepository memberRepository;

//    @Autowired //@RequiredArgsConstructor 가 final repositry를 찾아서 주입해줌
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    @Transactional(readOnly = false)
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Exception
        List<Member> findMembers= memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
