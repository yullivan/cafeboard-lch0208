package cafeboard.member;

import cafeboard.JwtProvider;
import cafeboard.SecurityUtils;
import org.springframework.stereotype.Service;

import static cafeboard.SecurityUtils.sha256Encrypt;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    public MemberService(MemberRepository memberRepository, JwtProvider jwtProvider) {
        this.memberRepository = memberRepository;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponse login(LoginRequest loginRequest){

        Member member = memberRepository.findByLoginId(loginRequest.loginId())
                .orElseThrow(() -> new IllegalArgumentException("Id 또는 Password가 틀립니다."));

        //** SecurityUtils 에서 sha256Encrypt 함수 호출하기
        if (!member.getPassword().equals(SecurityUtils.sha256Encrypt(loginRequest.password()))) {
            throw new IllegalArgumentException("Id 또는 Password가 틀립니다.");
        }

        //**아이디 비번이 문제없다고 가정하는 코드
        return new LoginResponse(jwtProvider.createToken(member.getLoginId()));
    }
}
