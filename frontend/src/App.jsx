import {useEffect, useState} from 'react'
import { fetchPosts } from "./posts.jsx";

function App() {
  const [posts, setPosts] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchPosts()
        .then(setPosts)
        .catch((reqError) => setError(reqError.message));
  }, []);

  if (error) {
    return <p>{error}</p>;
  }

  return (
      <main>
        <h1>jammd1의 블로그</h1>
        {posts.length === 0 && <p>조회된 게시글이 없습니다.</p>}
        {posts.length >= 1 &&  <ul>
          {posts.map((post) => (
              <li key = {post.id}>
                {post.title}
              </li>
          ))}
        </ul>}
      </main>
  );
}

export default App
