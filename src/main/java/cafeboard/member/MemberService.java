package cafeboard.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void login(LoginRequest loginRequest){


        Member member = memberRepository.findByLoginId(loginRequest.loginId())
                .orElseThrow();
        if (!member.getPassword().equals(loginRequest.password())) {
            throw new IllegalArgumentException("에러");
        }

    }
}
