import { Container, Links, Logo, StyledHeader } from "./Header.style";

function Header() {
	return (
		<StyledHeader>
			<Container>
				<Logo>Step 3</Logo>
				<Links>
					<li>Projects</li>
					<li>Login</li>
				</Links>
			</Container>
		</StyledHeader>
	);
}

export default Header;
