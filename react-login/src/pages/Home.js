import { StyledTitle, StyledSubTitle, Avatar, StyledButton, ButtonGroup } from "../components/Styles";

import logo from "./../assets/isabelle.jpg";

const Home = () => {
    return (
        <div>

            <div style={{
                position: "absolute",
                top: 0,
                left: 0,
                backgroundColor: "transparent",
                width: "100%",
                padding: "15px",
                display: "flex",
                justifyContent: "flex-start"
            }}>
                <Avatar image={logo}></Avatar>
            </div>

            <StyledTitle size={65}>
                Welcome To Idk.
            </StyledTitle>
            <StyledSubTitle size={25}>
                I'm a failure.
            </StyledSubTitle>

            <ButtonGroup>
                <StyledButton to="/login">
                    Log-in
                </StyledButton>
                <StyledButton to="signup">
                    Sign-up
                </StyledButton>
            </ButtonGroup>
        </div>
    );
}

export default Home;