import { css, styled } from 'styled-components';

interface Size {
  width: string;
  height: string;
}

interface Props extends Size {
  name: string;
  onChange(e: React.FormEvent<HTMLInputElement>): void;
}

const StyledInput = styled.input<Size>`
  ${({ width, height }) => css`
    width: ${width};
    height: ${height};
  `};
`;

function Input({ name, width, height, onChange }: Props) {
  return (
    <StyledInput
      name={name}
      width={width}
      height={height}
      onChange={onChange}
    ></StyledInput>
  );
}

export default Input;
