import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_home/friends/$id')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div>Hello "/_home/friends/$id"!</div>
}
