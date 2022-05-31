// npm i formik
import { useField } from "formik";
import { StyledTextInput, StyledLabel, StyledIcon } from "./Styles";

export const TextInput = ({icon, ...props}) => {
    const {field, meta} = useField(props);

    return (
        <div style={{position: "relative"}}>
            <StyledLabel 
            htmlFor={props.name}>
            {props.label}
            </StyledLabel>
            
            <StyledTextInput 
            {...field} 
            {...props}>
            </StyledTextInput>

            <StyledIcon>
                {icon}
            </StyledIcon>
        </div>
    );
}