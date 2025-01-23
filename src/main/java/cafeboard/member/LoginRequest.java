package cafeboard.member;

public record LoginRequest(
        String loginId,
        String password
) {
}
