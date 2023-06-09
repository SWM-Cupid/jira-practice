import axios from 'axios';
import Button from 'components/Button';
import Input from 'components/Input';
import { useState } from 'react';

function App() {
  const [form, setform] = useState({
    title: '',
    author: '',
    content: '',
  });

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setform({ ...form, [e.target.name]: e.target.value });
  };

  // 게시글 등록하기
  const onClick = () => {
    const url = 'http://url';
    axios
      .post(url, form)
      .then((response) => {
        console.log(response);
      })
      .catch((e) => {
        console.log(e);
      });
  };

  return (
    <>
      <h1>Vite + React + TypeScript</h1>
      <Button width="100px" height="50px" onClick={onClick}>
        생성
      </Button>

      <h4>제목</h4>
      <Input name="title" width="300px" height="20px" onChange={onChange} />

      <h4>작성자</h4>
      <Input name="author" width="100px" height="20px" onChange={onChange} />

      <h4>본문</h4>
      <Input name="content" width="400px" height="20px" onChange={onChange} />
    </>
  );
}

export default App;
