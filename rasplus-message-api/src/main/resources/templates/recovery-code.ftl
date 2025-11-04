<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .email-container {
            max-width: 600px;
            margin: 20px auto;
            background: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
        }
        .email-header {
            background-color: #e31c79;
            color: #ffffff;
            padding: 20px;
            text-align: center;
        }
        .email-header h1 {
            color: #ffffff;
        }
        .email-body {
            padding: 20px;
            color: #333333;
            line-height: 1.6;
        }
        .email-footer {
            background-color: #f1f1f1;
            padding: 15px;
            text-align: center;
            font-size: 14px;
            color: #666666;
        }
        .recovery-code {
            display: block;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            margin: 20px 0;
            padding: 10px;
            background-color: #e9ecef;
            border: 1px dashed #6c757d;
            border-radius: 4px;
            color: #e31c79;
        }
    </style>
</head>
<body>

<div class="email-container">
    <div class="email-header">
        <h1>${title}</h1>
    </div>
    <div class="email-body">
        <p>${helloMessage},</p>
        <p>${message1}</p>
        <span class="recovery-code">${recoveryCode}</span>
        <p>${message2}</p>
    </div>
    <div class="email-footer">
        <p>&copy; 2024 Rasmoo Plus. ${rightsReserved}</p>
    </div>
</div>

<!-- Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>