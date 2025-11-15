import { createFileRoute } from '@tanstack/react-router'

export const Route = createFileRoute('/_home/notifications/')({
  component: RouteComponent,
})

function RouteComponent() {
  return <div>Hello "/_home/notifications/"!</div>
}
