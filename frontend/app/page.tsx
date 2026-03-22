import Link from "next/link";

export default function Home() {
  return (
    <div>
      <h1>Hello World</h1>
      <Link href="/login"> Go to login</Link>
      <br />
      <Link href="/register"> Go to register</Link>
    </div>
  );
}
