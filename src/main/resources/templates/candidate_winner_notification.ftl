<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Election Winner Notification</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .email-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .email-header {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            padding: 40px 20px;
            text-align: center;
        }
        .email-header h1 {
            margin: 0;
            font-size: 32px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }
        .email-header .trophy {
            font-size: 60px;
            margin-bottom: 10px;
        }
        .email-body {
            padding: 30px;
            line-height: 1.6;
            color: #333333;
        }
        .congratulations {
            text-align: center;
            font-size: 24px;
            color: #28a745;
            font-weight: bold;
            margin: 20px 0;
        }
        .winner-details {
            background: linear-gradient(135deg, #e8f5e9 0%, #c8e6c9 100%);
            border-left: 5px solid #28a745;
            padding: 25px;
            margin: 25px 0;
            border-radius: 5px;
        }
        .winner-details h2 {
            margin-top: 0;
            color: #1b5e20;
            font-size: 22px;
            border-bottom: 2px solid #28a745;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }
        .detail-item {
            margin: 15px 0;
            font-size: 16px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .detail-label {
            font-weight: bold;
            color: #2e7d32;
            min-width: 150px;
        }
        .detail-value {
            color: #333333;
            text-align: right;
            flex: 1;
        }
        .vote-stats {
            background-color: #fff;
            border: 2px solid #28a745;
            padding: 20px;
            margin: 20px 0;
            border-radius: 5px;
        }
        .progress-bar-container {
            background-color: #e0e0e0;
            border-radius: 10px;
            height: 30px;
            margin: 15px 0;
            overflow: hidden;
            position: relative;
        }
        .progress-bar {
            background: linear-gradient(90deg, #28a745 0%, #4caf50 100%);
            height: 100%;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
            transition: width 0.3s ease;
        }
        .winner-badge {
            background-color: #ffd700;
            color: #1b5e20;
            padding: 8px 16px;
            border-radius: 20px;
            font-weight: bold;
            display: inline-block;
            margin: 10px 0;
            box-shadow: 0 2px 5px rgba(255, 215, 0, 0.3);
        }
        .email-footer {
            background-color: #f8f9fa;
            padding: 20px;
            text-align: center;
            border-top: 1px solid #dee2e6;
            color: #6c757d;
            font-size: 14px;
        }
        .email-footer p {
            margin: 5px 0;
        }
        .message-box {
            background-color: #fff3cd;
            border-left: 4px solid #ffc107;
            padding: 15px;
            margin: 20px 0;
            border-radius: 4px;
        }
        @media only screen and (max-width: 600px) {
            .email-container {
                margin: 0;
                border-radius: 0;
            }
            .email-header h1 {
                font-size: 24px;
            }
            .detail-item {
                flex-direction: column;
                align-items: flex-start;
            }
            .detail-value {
                text-align: left;
                margin-top: 5px;
            }
        }
    </style>
</head>
<body>
    <div class="email-container">
        <!-- Header Section -->
        <div class="email-header">
            <div class="trophy">🏆</div>
            <h1>Congratulations!</h1>
            <p style="margin: 10px 0 0 0; font-size: 18px;">Election Results Announcement</p>
        </div>

        <!-- Body Section -->
        <div class="email-body">
            <#if isWinner?? && isWinner>
                <div class="congratulations">
                    🎉 You Have Won the Election! 🎉
                </div>
                
                <p style="font-size: 16px;">
                    Dear <strong>${candidateName}</strong>,
                </p>

                <p>
                    We are delighted to inform you that you have been declared the <strong>winner</strong> of the 
                    <strong>${electionName}</strong>. Your dedication, vision, and the trust placed in you by the voters 
                    have led to this remarkable victory.
                </p>

                <div class="winner-badge">
                    ✓ WINNER
                </div>
            <#else>
                <p style="font-size: 16px;">
                    Dear <strong>${candidateName}</strong>,
                </p>

                <p>
                    Thank you for your participation in the <strong>${electionName}</strong>. The election results 
                    have been finalized, and we appreciate your commitment and dedication throughout the campaign.
                </p>
            </#if>

            <!-- Winner Details Section -->
            <div class="winner-details">
                <h2>Election Results</h2>
                
                <div class="detail-item">
                    <span class="detail-label">Candidate Name:</span>
                    <span class="detail-value">${candidateName}</span>
                </div>

                <div class="detail-item">
                    <span class="detail-label">Party Name:</span>
                    <span class="detail-value">${partyName}</span>
                </div>

                <div class="detail-item">
                    <span class="detail-label">Election:</span>
                    <span class="detail-value">${electionName}</span>
                </div>
            </div>

            <!-- Vote Statistics Section -->
            <div class="vote-stats">
                <h3 style="margin-top: 0; color: #28a745;">Vote Statistics</h3>
                
                <div class="detail-item">
                    <span class="detail-label">Votes Received:</span>
                    <span class="detail-value" style="font-size: 20px; font-weight: bold; color: #28a745;">
                        ${votesReceived?string.number}
                    </span>
                </div>

                <div class="detail-item">
                    <span class="detail-label">Total Votes Cast:</span>
                    <span class="detail-value">${totalVotes?string.number}</span>
                </div>

                <div class="detail-item">
                    <span class="detail-label">Vote Percentage:</span>
                    <span class="detail-value" style="font-size: 18px; font-weight: bold; color: #28a745;">
                        ${votePercentage?string["0.##"]}%
                    </span>
                </div>

                <!-- Progress Bar -->
                <div class="progress-bar-container">
                    <div class="progress-bar" style="width: ${votePercentage}%;">
                        ${votePercentage?string["0.##"]}%
                    </div>
                </div>
            </div>

            <#if isWinner?? && isWinner>
                <div class="message-box">
                    <strong>Next Steps:</strong>
                    <p style="margin: 10px 0 0 0;">
                        Please contact the election commission for further instructions regarding your official 
                        responsibilities and the swearing-in ceremony details.
                    </p>
                </div>

                <p>
                    Once again, congratulations on your well-deserved victory! We wish you great success in your 
                    new role and look forward to the positive changes you will bring to the community.
                </p>
            <#else>
                <p>
                    We thank you for your participation and encourage you to stay engaged with the democratic process. 
                    Your contribution has been valuable to the community.
                </p>
            </#if>

            <p style="margin-top: 30px;">
                Best regards,<br>
                <strong>Election Commission Team</strong><br>
                Online Voting System
            </p>
        </div>

        <!-- Footer Section -->
        <div class="email-footer">
            <p><strong>Online Voting System</strong></p>
            <p>This is an automated notification. Please do not reply to this email.</p>
            <p>&copy; ${.now?string('yyyy')} Online Voting System. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
