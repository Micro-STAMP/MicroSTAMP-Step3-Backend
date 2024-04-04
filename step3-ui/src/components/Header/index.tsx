import styles from "./Header.module.scss";

function Header() {
	return (
		<header className={styles.Header}>
			<div className={styles.Container}>
				<h1 className={styles.Logo}>Step 3</h1>

				<ul className={styles.Links}>
					<li>Projects</li>
					<li>Login</li>
				</ul>
			</div>
		</header>
	);
}

export default Header;
