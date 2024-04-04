import styled from "styled-components";

// Color Pallete

// white: "#F5F5F5";
// dark: "#161616";
// background: "#333C4B";
// yellow: "#D4A056";
// container: "#4A4C5C";

export const StyledHeader = styled.header`
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100%;
	padding: 16px 0;
	box-shadow: 0 4px 4px #16161640;
`;
export const Container = styled.div`
	display: flex;
	justify-content: space-between;
	width: clamp(252px, 90%, 1440px);
	text-shadow: 0 4px 4px #16161640;
	margin: 0 16px;
`;
export const Logo = styled.h1`
	color: #d4a056;
	font-size: 1.5rem;
	font-weight: bold;
`;
export const Links = styled.ul`
	display: flex;
	align-items: center;
	gap: 1rem;
	font-size: 1.1rem;
	font-weight: 300;
`;
