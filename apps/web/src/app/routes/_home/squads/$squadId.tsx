import { createFileRoute } from '@tanstack/react-router';
import { useEffect, useRef, useState } from 'react';

export const Route = createFileRoute('/_home/squads/$squadId')({
  component: RouteComponent,
});

// Mock data
const MOCK_SQUADS = {
  '1': {
    id: '1',
    name: 'Dev Team',
    description: 'Main development squad',
    createdAt: '2024-01-15',
  },
  '2': {
    id: '2',
    name: 'Design Squad',
    description: 'UI/UX design collaboration',
    createdAt: '2024-02-01',
  },
  '3': {
    id: '3',
    name: 'Marketing',
    description: 'Marketing strategies and campaigns',
    createdAt: '2024-01-20',
  },
};

const MOCK_MEMBERS = [
  { id: '1', name: 'Alice Chen', status: 'online', avatar: '👩‍💻' },
  { id: '2', name: 'Bob Smith', status: 'online', avatar: '👨‍💼' },
  { id: '3', name: 'Carol White', status: 'away', avatar: '👩‍🎨' },
  { id: '4', name: 'David Lee', status: 'offline', avatar: '👨‍🔧' },
];

const MOCK_MESSAGES = [
  {
    id: '1',
    userId: '1',
    userName: 'Alice Chen',
    userAvatar: '👩‍💻',
    content: "Hey everyone! How's the project coming along?",
    timestamp: '10:30 AM',
  },
  {
    id: '2',
    userId: '2',
    userName: 'Bob Smith',
    userAvatar: '👨‍💼',
    content: 'Going great! Just finished the API integration.',
    timestamp: '10:32 AM',
  },
  {
    id: '3',
    userId: '3',
    userName: 'Carol White',
    userAvatar: '👩‍🎨',
    content: "I've updated the mockups. Check them out when you can!",
    timestamp: '10:35 AM',
  },
  {
    id: '4',
    userId: '1',
    userName: 'Alice Chen',
    userAvatar: '👩‍💻',
    content: "Awesome work team! Let's sync up tomorrow.",
    timestamp: '10:40 AM',
  },
];

function RouteComponent() {
  const { squadId } = Route.useParams();
  const [messages, setMessages] = useState(MOCK_MESSAGES);
  const [newMessage, setNewMessage] = useState('');
  const [showInviteModal, setShowInviteModal] = useState(false);
  const [inviteEmail, setInviteEmail] = useState('');
  const messagesEndRef = useRef<HTMLDivElement>(null);

  const squad = MOCK_SQUADS[squadId as keyof typeof MOCK_SQUADS] || {
    id: squadId,
    name: 'Unknown Squad',
    description: 'Squad not found',
    createdAt: new Date().toISOString(),
  };

  const scrollToBottom = () => {
    messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' });
  };

  useEffect(() => {
    scrollToBottom();
  }, [messages]);

  const handleSendMessage = (e: React.FormEvent) => {
    e.preventDefault();
    if (!newMessage.trim()) return;

    const message = {
      id: String(messages.length + 1),
      userId: '1',
      userName: 'Alice Chen',
      userAvatar: '👩‍💻',
      content: newMessage,
      timestamp: new Date().toLocaleTimeString('en-US', {
        hour: 'numeric',
        minute: '2-digit',
      }),
    };

    setMessages([...messages, message]);
    setNewMessage('');
  };

  const handleInvite = (e: React.FormEvent) => {
    e.preventDefault();
    if (!inviteEmail.trim()) return;

    // Mock invite logic
    alert(`Invitation sent to ${inviteEmail}`);
    setInviteEmail('');
    setShowInviteModal(false);
  };

  return (
    <div style={styles.container}>
      {/* Header */}
      <div style={styles.header}>
        <div style={styles.headerLeft}>
          <h1 style={styles.squadName}>{squad.name}</h1>
          <p style={styles.squadDescription}>{squad.description}</p>
        </div>
        <button
          onClick={() => setShowInviteModal(true)}
          style={styles.inviteButton}
        >
          + Invite Members
        </button>
      </div>

      <div style={styles.mainContent}>
        {/* Chat Section */}
        <div style={styles.chatSection}>
          <div style={styles.messagesContainer}>
            {messages.map((message) => (
              <div key={message.id} style={styles.message}>
                <div style={styles.messageAvatar}>{message.userAvatar}</div>
                <div style={styles.messageContent}>
                  <div style={styles.messageHeader}>
                    <span style={styles.messageName}>{message.userName}</span>
                    <span style={styles.messageTime}>{message.timestamp}</span>
                  </div>
                  <p style={styles.messageText}>{message.content}</p>
                </div>
              </div>
            ))}
            <div ref={messagesEndRef} />
          </div>

          {/* Message Input */}
          <form onSubmit={handleSendMessage} style={styles.messageForm}>
            <input
              type='text'
              value={newMessage}
              onChange={(e) => setNewMessage(e.target.value)}
              placeholder='Type a message...'
              style={styles.messageInput}
            />
            <button type='submit' style={styles.sendButton}>
              Send
            </button>
          </form>
        </div>

        {/* Members Sidebar */}
        <div style={styles.sidebar}>
          <h2 style={styles.sidebarTitle}>Members ({MOCK_MEMBERS.length})</h2>
          <div style={styles.membersList}>
            {MOCK_MEMBERS.map((member) => (
              <div key={member.id} style={styles.member}>
                <div style={styles.memberAvatar}>{member.avatar}</div>
                <div style={styles.memberInfo}>
                  <div style={styles.memberName}>{member.name}</div>
                  <div style={styles.memberStatus}>
                    <span
                      style={{
                        ...styles.statusDot,
                        backgroundColor:
                          member.status === 'online'
                            ? '#10b981'
                            : member.status === 'away'
                              ? '#f59e0b'
                              : '#6b7280',
                      }}
                    />
                    {member.status}
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* Invite Modal */}
      {showInviteModal && (
        <div
          style={styles.modalOverlay}
          onClick={() => setShowInviteModal(false)}
        >
          <div style={styles.modal} onClick={(e) => e.stopPropagation()}>
            <h2 style={styles.modalTitle}>Invite Members</h2>
            <p style={styles.modalDescription}>
              Send an invitation to join {squad.name}
            </p>
            <form onSubmit={handleInvite}>
              <input
                type='email'
                value={inviteEmail}
                onChange={(e) => setInviteEmail(e.target.value)}
                placeholder='Enter email address'
                style={styles.modalInput}
                autoFocus
              />
              <div style={styles.modalActions}>
                <button
                  type='button'
                  onClick={() => setShowInviteModal(false)}
                  style={styles.cancelButton}
                >
                  Cancel
                </button>
                <button type='submit' style={styles.submitButton}>
                  Send Invite
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    height: '100vh',
    backgroundColor: '#f9fafb',
  },
  header: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '20px 24px',
    backgroundColor: '#ffffff',
    borderBottom: '1px solid #e5e7eb',
  },
  headerLeft: {
    flex: 1,
  },
  squadName: {
    fontSize: '24px',
    fontWeight: '700',
    margin: '0 0 4px 0',
    color: '#111827',
  },
  squadDescription: {
    fontSize: '14px',
    color: '#6b7280',
    margin: 0,
  },
  inviteButton: {
    padding: '10px 20px',
    backgroundColor: '#3b82f6',
    color: '#ffffff',
    border: 'none',
    borderRadius: '8px',
    fontSize: '14px',
    fontWeight: '600',
    cursor: 'pointer',
    transition: 'background-color 0.2s',
  },
  mainContent: {
    display: 'flex',
    flex: 1,
    overflow: 'hidden',
  },
  chatSection: {
    flex: 1,
    display: 'flex',
    flexDirection: 'column',
    backgroundColor: '#ffffff',
    borderRight: '1px solid #e5e7eb',
  },
  messagesContainer: {
    flex: 1,
    overflowY: 'auto',
    padding: '20px',
    display: 'flex',
    flexDirection: 'column',
    gap: '16px',
  },
  message: {
    display: 'flex',
    gap: '12px',
  },
  messageAvatar: {
    width: '40px',
    height: '40px',
    borderRadius: '50%',
    backgroundColor: '#f3f4f6',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    fontSize: '20px',
    flexShrink: 0,
  },
  messageContent: {
    flex: 1,
  },
  messageHeader: {
    display: 'flex',
    alignItems: 'center',
    gap: '8px',
    marginBottom: '4px',
  },
  messageName: {
    fontSize: '14px',
    fontWeight: '600',
    color: '#111827',
  },
  messageTime: {
    fontSize: '12px',
    color: '#9ca3af',
  },
  messageText: {
    fontSize: '14px',
    color: '#374151',
    margin: 0,
    lineHeight: '1.5',
  },
  messageForm: {
    display: 'flex',
    gap: '12px',
    padding: '20px',
    borderTop: '1px solid #e5e7eb',
  },
  messageInput: {
    flex: 1,
    padding: '12px 16px',
    border: '1px solid #d1d5db',
    borderRadius: '8px',
    fontSize: '14px',
    outline: 'none',
    transition: 'border-color 0.2s',
  },
  sendButton: {
    padding: '12px 24px',
    backgroundColor: '#3b82f6',
    color: '#ffffff',
    border: 'none',
    borderRadius: '8px',
    fontSize: '14px',
    fontWeight: '600',
    cursor: 'pointer',
    transition: 'background-color 0.2s',
  },
  sidebar: {
    width: '280px',
    backgroundColor: '#ffffff',
    display: 'flex',
    flexDirection: 'column',
    overflowY: 'auto',
  },
  sidebarTitle: {
    fontSize: '16px',
    fontWeight: '700',
    padding: '20px',
    margin: 0,
    color: '#111827',
    borderBottom: '1px solid #e5e7eb',
  },
  membersList: {
    padding: '12px',
    display: 'flex',
    flexDirection: 'column',
    gap: '4px',
  },
  member: {
    display: 'flex',
    alignItems: 'center',
    gap: '12px',
    padding: '12px',
    borderRadius: '8px',
    cursor: 'pointer',
    transition: 'background-color 0.2s',
  },
  memberAvatar: {
    width: '36px',
    height: '36px',
    borderRadius: '50%',
    backgroundColor: '#f3f4f6',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    fontSize: '18px',
    flexShrink: 0,
  },
  memberInfo: {
    flex: 1,
  },
  memberName: {
    fontSize: '14px',
    fontWeight: '500',
    color: '#111827',
    marginBottom: '2px',
  },
  memberStatus: {
    fontSize: '12px',
    color: '#6b7280',
    display: 'flex',
    alignItems: 'center',
    gap: '6px',
    textTransform: 'capitalize',
  },
  statusDot: {
    width: '8px',
    height: '8px',
    borderRadius: '50%',
  },
  modalOverlay: {
    position: 'fixed',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    zIndex: 1000,
  },
  modal: {
    backgroundColor: '#ffffff',
    borderRadius: '12px',
    padding: '24px',
    width: '90%',
    maxWidth: '400px',
    boxShadow: '0 20px 25px -5px rgba(0, 0, 0, 0.1)',
  },
  modalTitle: {
    fontSize: '20px',
    fontWeight: '700',
    margin: '0 0 8px 0',
    color: '#111827',
  },
  modalDescription: {
    fontSize: '14px',
    color: '#6b7280',
    margin: '0 0 20px 0',
  },
  modalInput: {
    width: '100%',
    padding: '12px 16px',
    border: '1px solid #d1d5db',
    borderRadius: '8px',
    fontSize: '14px',
    outline: 'none',
    marginBottom: '20px',
    boxSizing: 'border-box',
  },
  modalActions: {
    display: 'flex',
    gap: '12px',
    justifyContent: 'flex-end',
  },
  cancelButton: {
    padding: '10px 20px',
    backgroundColor: '#f3f4f6',
    color: '#374151',
    border: 'none',
    borderRadius: '8px',
    fontSize: '14px',
    fontWeight: '600',
    cursor: 'pointer',
    transition: 'background-color 0.2s',
  },
  submitButton: {
    padding: '10px 20px',
    backgroundColor: '#3b82f6',
    color: '#ffffff',
    border: 'none',
    borderRadius: '8px',
    fontSize: '14px',
    fontWeight: '600',
    cursor: 'pointer',
    transition: 'background-color 0.2s',
  },
};
