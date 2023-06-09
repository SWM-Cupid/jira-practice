import { css, styled } from 'styled-components';

interface Size {
  width: string;
  height: string;
}

interface Props extends Size {
  onClick(): void;
  children: string;
}

const StyledButton = styled.button<Size>`
  ${({ width, height }) => css`
    width: ${width};
    height: ${height};
  `};
`;

function Button({ width, height, children, onClick }: Props) {
  return (
    <StyledButton width={width} height={height} onClick={onClick}>
      {children}
    </StyledButton>
  );
}

export default Button;
