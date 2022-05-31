// styles
import {Avatar, colors, StyledTitle, StyledTextInput, StyledFormArea, StyledFormButton, StyledLabel, ButtonGroup} from './../components/Styles';
import logo from './../assets/isabelle.jpg';

// npm i formik
import {Formik, Form} from 'formik';
import { TextInput } from '../components/FormLib';

// other imports...
import {FiMail, FiLock} from 'react-icons/fi';
import * as Yup from 'yup'; // npm install -S yup

const Login = () => {
    return (
        <div>
            <StyledFormArea>

                <Avatar image={logo}></Avatar>
                <StyledTitle color={colors.theme} size={30}>
                    Member Log-in
                </StyledTitle>

                <Formik initialValues={{
                        email: "", password:""}} 
                        onSubmit = {(values, {setSubmitting}) => {console.log(values);
                        }}>
                    {() => (
                        <Form>
                            <TextInput
                            name="email"
                            type="text"
                            label="E-mail address"
                            placeholder="daria@sicksadworld.com"
                            icon={<FiMail></FiMail>}>
                            </TextInput>

                            <TextInput
                            name="password"
                            type="password"
                            label="Password"
                            placeholder="**********"
                            icon={<FiLock></FiLock>}>
                            </TextInput>

                            <ButtonGroup>
                                <StyledFormButton type="submit">
                                    Log-in
                                </StyledFormButton>
                            </ButtonGroup>

                        </Form>
                    )}
                </Formik>

            </StyledFormArea>

        </div>
    );
}

export default Login;